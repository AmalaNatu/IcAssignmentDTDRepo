package com.Domdtd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Domparserddt {

	public static void main(String[] args) {
		String flag="true";
		try {
		validate("animals.xml");
		} catch (ParserConfigurationException e) {

		flag="false";
		}
		catch (FileNotFoundException e) {

		flag="false1";
		}
		catch (SAXException e) {

		flag="false2";
		}
		catch (IOException e) {

		flag="false3";
		}
		System.out.println("xml file is valid: " +flag);
		}
		public static void validate(String xmlFile) throws ParserConfigurationException,FileNotFoundException,SAXException,IOException {
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(true);
		DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
		documentBuilder.setErrorHandler(new org.xml.sax.ErrorHandler() {
		public void error(SAXParseException exception) throws SAXException{
		throw exception;
		}
		public void fatalError(SAXParseException exception)throws SAXException{
		throw exception;
		}
		@Override
		public void warning(SAXParseException exception) throws SAXException {
		throw exception;
		}

		});
		documentBuilder.parse(new FileInputStream(xmlFile));

	}

}
