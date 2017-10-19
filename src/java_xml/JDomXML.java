/**
 * JDOM��ʽ����XML����XML�Ľ������ұ�ʹ��DOMʵ��
 * ����,��ʹ�þ��������ʹ�ýӿ���˼���API,��������ʹ��
 * jdom-2.0.6.jar
 */

package java_xml;

import java.io.FileInputStream;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JDomXML {
	private String fileName = "XML/poem.xml";
	Document document = null;

	public JDomXML(){
		try{
			SAXBuilder saxBuilder = new SAXBuilder();
			document = saxBuilder.build(new FileInputStream(fileName));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * print XML info
	 */
	public void printMsg(){
		Element rootElement = document.getRootElement();
		System.out.println(rootElement);
		// get children nodes as list
		List<Element> poemList = rootElement.getChildren();
		// print children elements info
		poemList.forEach(s->printElement(s));
	}

	/**
	 * print element info
	 * @param element
	 */
	public void printElement(Element e){
		// element name
		System.out.print(e.getName() + "\t");
		// print attributes
		List<Attribute> attributes = e.getAttributes();
		attributes.forEach(s->System.out.print(s.getName() + ":" + s.getValue() + "\t"));
		System.out.println();
		// print text that is empty
		if(!(e.getTextTrim().equals(""))){
			System.out.print(e.getTextTrim());
		}
		// loop for children nodes
		List<Element> poemList = e.getChildren();
		poemList.forEach(s->printElement(s));
	}

	// This is a test
	public static void main(String[] args) {
		new JDomXML().printMsg();
	}
}