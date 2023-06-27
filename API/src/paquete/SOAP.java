package paquete;

import java.net.MalformedURLException;
import java.net.URL;

public class SOAP {
	public static void main(String [] args) {
		
	try {
		URL url = new URL("https://pokeapi.co/api/v2/pokemon/pikachu");
		QName serviceName = new QName("");
		Service service = Service.create(url,serviceName);
		Dispatch<SOAPMessage> dispatch = service.createDispatch(
				new QName())
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}