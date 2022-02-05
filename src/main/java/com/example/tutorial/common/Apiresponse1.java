package com.example.tutorial.common;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class Apiresponse1<T> {
	
	
	
	int recordCount;
    T response;
	
	

}
