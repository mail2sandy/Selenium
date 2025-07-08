package testCases;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TC011_ReadXmlData {

	//DocumentBuilderFactory
	//DocumentBuilder
	//Document
	//NodeList
	//Node
	//Element

	@Test
	public void readFromXml() throws Exception, IOException {
	DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
	DocumentBuilder DB = DBF.newDocumentBuilder();
	
	Document Doc = DB.parse(".\\testData\\emp.xml");
	
	Doc.getDocumentElement().normalize();
	
    System.out.println("Root element :" + Doc.getDocumentElement().getNodeName());
    
    NodeList listItems = Doc.getElementsByTagName("person");
    listItems.getLength();
    
    for(int i =0; i < listItems.getLength();i++) {
    	
    	Node list = listItems.item(i);
        System.out.println("\nCurrent Element :" + list.getNodeName());
        Element xmlValue = (Element) list;
        
        System.out.println(xmlValue.getTagName());
        System.out.println(xmlValue.getTextContent());
    	
    }
	
	Element rootNode = Doc.getDocumentElement();
	
	NodeList nodeL = rootNode.getChildNodes();
	nodeL.getLength();
	
	ArrayList<String> cList = new ArrayList<>();

	for(int i = 0; i < nodeL.getLength(); i ++) {
		
		Node data = nodeL.item(i);
		
		if (data.getNodeType() == Node.ELEMENT_NODE) {
	        Element actualData = (Element) data;
			System.out.println(actualData.getTagName());
			System.out.println(actualData.getTextContent());
            String name = actualData.getElementsByTagName("name").item(0).getTextContent();
            String age = actualData.getElementsByTagName("age").item(0).getTextContent();
            String city = actualData.getElementsByTagName("city").item(0).getTextContent();
            cList.add(name);
            cList.add(age);
            cList.add(city);
            
			
		}


	}
	
    System.out.println("Item names: " + cList);

	
	
	}
	
}
