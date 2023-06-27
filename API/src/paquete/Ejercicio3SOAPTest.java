package paquete;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Provider.Service;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class Ejercicio3SOAPTest {
	/*
	 * SOAP: Simple Object Access Protocol o "Protocolo simple de acceso" es un
	 * protocolo de comunicación utilizado para intercambiar datos estructurados en
	 * servicios web. SOAP define una forma estandar de codificar mensajes XML que
	 * se envian y reciben en aplicaciones distribuidas.
	 * 
	 * Se define una serie de reglas y estandares para construir mensajes SOAP, como
	 * la estructura XML del mensaje, el formato de la solicitud y la respuesta, y
	 * como se manejan los errores.
	 */
	@Test
	public void testJunit() {
		{
			String operation = null;
			String operationResponse = null;
			System.out.println(
					"Calculadora lista, que operación desea realizar: \n1.- Suma \n2.- Resta \n3.- Multiplicación \n4.- División");
			Scanner sc = new Scanner(System.in);
			int x;
			do {
				System.out.println("Por favor introduzca un numero entre el 1 y el 4)");
				x = sc.nextInt();
			} while (x < 1 || x > 4);
			switch (x) {
			case 1:
				operation = "Add";
				operationResponse = "AddResponse";
				break;
			case 2:
				operation = "Subtract";
				operationResponse = "SubtractResponse";
				break;
			case 3:
				operation = "Multiply";
				operationResponse = "MultiplyResponse";
				break;
			case 4:
				operation = "Divide";
				operationResponse = "DivideResponse";
				break;
			}
			try {
				String endpoint = "http://dneonline.com/calculator.asmx";
				// SOAPConnectionFactory soapCOnnectionFactory =
				// SOAPConnectionFactory.newInstance();
				// Creamos la conexion
				SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
				SOAPConnection soapConnection = soapConnectionFactory.createConnection();
				// Creamos el mensaje SOAP
				MessageFactory messageFactory = MessageFactory.newInstance();
				SOAPMessage soapMessage = messageFactory.createMessage();
				// Crear el cuerpo del mensaje SOAP
				SOAPPart soapPart = soapMessage.getSOAPPart();
				SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
				// SOAPMessage soapResponse = soapConnection.call(soapMessage, endpoint);
				SOAPBody soapBody = soapEnvelope.getBody();

				// En base a la documentación, se declaran los elementos intA e intB
				SOAPElement operationElement = soapBody.addChildElement(operation, "", "http://tempuri.org/");
				SOAPElement intAElement = operationElement.addChildElement("intA");
				System.out.println("Introduce primer valor");
				intAElement.addTextNode((sc.next()));
				SOAPElement intBElement = operationElement.addChildElement("intB");
				System.out.println("Introduce segundo valor");
				intBElement.addTextNode((sc.next()));
				// Enviar el mensaje SOAP y recibir la respuesta
				SOAPMessage soapResponse = soapConnection.call(soapMessage, endpoint);
				// Procesamos la respuesta.
				SOAPBody responseBody = soapResponse.getSOAPBody();
				SOAPElement responseElement = (SOAPElement) responseBody.getElementsByTagName(operationResponse)
						.item(0);
				String resultado = responseElement.getTextContent();
				System.out.println("Respuesta: " + resultado);
				soapConnection.close();
				sc.close();

				// -----TEST-----//
				// Resultado devuelve siempre respuesta
				assertFalse(resultado.length() == 0);
				// La respuesta es un valor numerico
				assertTrue(StringUtils.isNumeric((resultado)));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}