package com.tugas.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProduct<T> {
	private int statusCode;
	private String pesan;
	private T data;

}
