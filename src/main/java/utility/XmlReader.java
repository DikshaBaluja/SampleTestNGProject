package utility;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XmlReader  {

	public static String  readXmlFile(String searchNode) throws Exception
	{



		File xmlFile = new File("src/test/java/testData/TestData.xml");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance() ;
		DocumentBuilder dbuilder = factory.newDocumentBuilder();
		Document doc = dbuilder.parse(xmlFile);

		doc.getDocumentElement().getNodeName();

		NodeList nList = doc.getElementsByTagName("Ecommerce");
		
		String nodeContent="";

		for (int i = 0; i < nList.getLength(); i++) 
		{
			Node nNode = nList.item(i);

			System.out.println("\nCurrent Element: " + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) 
			{

				Element element = (Element) nNode;


				Node node = element.getElementsByTagName(searchNode).item(0);
				nodeContent = node.getTextContent();
				

			}   


		}
		
		return nodeContent;


	}

}







