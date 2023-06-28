package paquete;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Provider.Service;
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
public class SOAP 
{
/*
SOAP: Simple Object Access Protocol o "Protocolo simple de acceso"
es un protocolo de comunicación utilizado para intercambiar datos estructurados
en servicios web. SOAP define una forma estandar de codificar mensajes XML
que se envian y reciben en aplicaciones distribuidas. 

Se define una serie de reglas y estandares para construir mensajes SOAP,
como la estructura XML del mensaje, el formato de la solicitud y la respuesta,
y como se manejan los errores. 
*/
	public static void main (String [] args)
	{
		try {
			String endpoint = "http://dneonline.com/calculator.asmx"; //declaro el endpoint
			//SOAPConnectionFactory soapCOnnectionFactory = SOAPConnectionFactory.newInstance();
			//Creamos la conexion
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance(); //genero una nueva instancia de la conexion a la factory
			SOAPConnection soapConnection = soapConnectionFactory.createConnection(); //creo una nueva conexion con el endpoint
			//Creamos el mensaje SOAP
			MessageFactory messageFactory = MessageFactory.newInstance(); //Declaro el messageFactory que me permite acceder al SOAPMessage
			SOAPMessage soapMessage = messageFactory.createMessage(); //declaro el SOAPMessage que me permite acceder al SOAPPart, el cual me permite obtener el envelope
			//Crear el cuerpo del mensaje SOAP
			SOAPPart soapPart = soapMessage.getSOAPPart(); //obtengo el SOAPPart que es el encargado de contener el envelope  
			SOAPEnvelope soapEnvelope = soapPart.getEnvelope(); //obtengo el envelope que es el encargado de contener el cuerpo del mensaje
			//SOAPMessage soapResponse = soapConnection.call(soapMessage, endpoint);
			SOAPBody soapBody = soapEnvelope.getBody(); //obtengo el mensaje que contiene la respuesta de la API.	
			//En base a la documentación, se declaran los elementos intA e intB
			//Suma			
			//SOAPElement permite declarar elementos (variables) dentro del contexto de SOAP.
			//Un elemento de SOAP es parte de la estructura XML utilizada para ENVIAR y RECIBIR datos.
			SOAPElement operationElement = soapBody.addChildElement("Add", "", "http://tempuri.org/"); //declaro la suma
			SOAPElement intAElement = operationElement.addChildElement("intA"); //declaro el intA
			intAElement.addTextNode("10");
			SOAPElement intBElement = operationElement.addChildElement("intB");
			intBElement.addTextNode("5");
			//Enviar el mensaje SOAP y recibir la respuesta
			SOAPMessage soapResponse = soapConnection.call(soapMessage, endpoint); //hacemos el llamado al endpoint con el mensaje
			//Procesamos la respuesta.
			SOAPBody responseBody = soapResponse.getSOAPBody(); //obtenemos el body
			SOAPElement responseElement = (SOAPElement) responseBody.getElementsByTagName("AddResponse").item(0); //obtenemos el elemento de respuesta del body
			String resultado = responseElement.getTextContent(); //obtenemos el String con el valor informado
			System.out.println("Respuesta: " + resultado); //mostramos por pantalla.		
			//Resta
			SOAPMessage soapMessageResta = messageFactory.createMessage();
			soapPart = soapMessageResta.getSOAPPart();
			soapEnvelope = soapPart.getEnvelope();
			soapBody = soapEnvelope.getBody();
			SOAPElement operationElementResta = soapBody.addChildElement("Subtract", "", "http://tempuri.org/");
			SOAPElement intAElementResta = operationElementResta.addChildElement("intA");
			intAElementResta.addTextNode("10");
			SOAPElement intBElementResta = operationElementResta.addChildElement("intB");
			intBElementResta.addTextNode("5");
			SOAPMessage soapResponseResta = soapConnection.call(soapMessageResta, endpoint);
			SOAPBody responseBodyResta = soapResponseResta.getSOAPBody();
			SOAPElement responseElementResta = (SOAPElement) responseBodyResta.getElementsByTagName("SubtractResponse").item(0);
			String resultadoResta = responseElementResta.getTextContent();
			System.out.println("La resta es: " + resultadoResta);
			//Multiplicacion
			SOAPMessage soapMessageMultiplicacion = messageFactory.createMessage();
			soapPart = soapMessageMultiplicacion.getSOAPPart();
			soapEnvelope = soapPart.getEnvelope();
			soapBody = soapEnvelope.getBody();
			SOAPElement operationElementMultiplication = soapBody.addChildElement("Multiply", "", "http://tempuri.org/");
			SOAPElement intAElementMultiplicacion = operationElementMultiplication.addChildElement("intA");
			intAElementMultiplicacion.addTextNode("10");
			SOAPElement intBElementMultiplicacion = operationElementMultiplication.addChildElement("intB");
			intBElementMultiplicacion.addTextNode("10");
			SOAPMessage soapResponseMultiplicacion = soapConnection.call(soapMessageMultiplicacion, endpoint);
			SOAPBody responseBodyMultiplicacion = soapResponseMultiplicacion.getSOAPBody();
			SOAPElement responseElementMultiplicacion = (SOAPElement) responseBodyMultiplicacion.getElementsByTagName("MultiplyResponse").item(0);
			String resultadoMultiplicacion = responseElementMultiplicacion.getTextContent();
			System.out.println("La multiplicación es: " + resultadoMultiplicacion);
			//Division
			SOAPMessage soapMessageDivision = messageFactory.createMessage();
			soapPart = soapMessageDivision.getSOAPPart();
			soapEnvelope = soapPart.getEnvelope();
			soapBody = soapEnvelope.getBody();
			SOAPElement operationElementDivision = soapBody.addChildElement("Divide", "", "http://tempuri.org/");
			SOAPElement intAElementDivision = operationElementDivision.addChildElement("intA");
			intAElementDivision.addTextNode("10");
			SOAPElement intBElementDivision = operationElementDivision.addChildElement("intB");
			intBElementDivision.addTextNode("10");
			SOAPMessage soapResponseDivision = soapConnection.call(soapMessageDivision, endpoint);
			SOAPBody responseBodyDivision = soapResponseDivision.getSOAPBody();
			SOAPElement responseElementDivision = (SOAPElement) responseBodyDivision.getElementsByTagName("DivideResponse").item(0);
			String resultadoDivision = responseElementDivision.getTextContent();
			System.out.println("La multiplicación es: " + resultadoDivision);
			
			soapConnection.close(); //cierro la conexion
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
	}