package com.myexample.config;

import java.beans.PropertyEditor;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.myexample.model.Student;
import com.myexample.writter.StudentWritter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class StudentBatchConfig {
	private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	@Bean(destroyMethod="")
	@StepScope
	public FlatFileItemReader<Student> countryReader(@Value("${input.student.path}") Resource resource) throws IOException {
		log.debug("Resource Path : "+resource.getFile());
		
		FlatFileItemReader<Student> itemReader = new FlatFileItemReader<>();
		itemReader.setName("STUDENT_READER");
		itemReader.setResource(resource);
		itemReader.setLineMapper(studentLineMapper());
		itemReader.setLinesToSkip(1);
		return itemReader;
	}
	
	@SuppressWarnings("rawtypes")
	@Bean
	public LineMapper<Student> studentLineMapper() {
		DefaultLineMapper<Student> lineMapper = new DefaultLineMapper<>();

		// Delimited Line Tokenizer
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id", "firstName", "lastName", "dateOfBirth");
		lineTokenizer.setIncludedFields(new int[] {0,1,2,3});

		// Date parsing logic has been added
		CustomDateEditor customDateEditor = new CustomDateEditor(format, false);
		
		HashMap<Class, PropertyEditor> customEditors = new HashMap<>();
		customEditors.put(Date.class, customDateEditor);
		
		// Bean Wrapper Field SetMapper
		BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Student.class);
		fieldSetMapper.setCustomEditors(customEditors);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}
	
	@Bean
	public StudentWritter studentWritter() {
		return new StudentWritter();
	}
}
