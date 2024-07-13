package com.kino.study.factory.di.parser;

import com.kino.study.factory.di.definition.BeanDefinition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author kino
 * @date 2024/7/13 18:54
 */
public class XmlBeanConfigParser implements BeanConfigParser {
    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        String content = convert(inputStream);
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(configContent.getBytes()));
            Element root = doc.getDocumentElement();
            NodeList beanNodes = root.getElementsByTagName("bean");
            if (beanNodes.getLength() == 0) {
                throw new IllegalArgumentException("No <bean> elements found in XML");
            }
            for (int j = 0; j < beanNodes.getLength(); j++) {
                Element beanElement = (Element) beanNodes.item(j);
                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setId(beanElement.getAttribute("id"));
                beanDefinition.setClassName(beanElement.getAttribute("class"));
                NodeList constructorArgs = beanElement.getElementsByTagName("constructor-arg");
                List<BeanDefinition.ConstructorArg> constructorArgList = new ArrayList<>();
                for (int i = 0; i < constructorArgs.getLength(); i++) {
                    Element argElement = (Element) constructorArgs.item(i);
                    boolean isRef = "ref".equals(argElement.getAttribute("type"));
                    Class<?> type = getClassType(argElement.getAttribute("type"));
                    Object arg = isRef ? argElement.getAttribute("value") : parseValue(type, argElement.getAttribute("value"));
                    constructorArgList.add(new BeanDefinition.ConstructorArg(isRef, type, arg));
                }

                beanDefinition.setConstructorArgs(constructorArgList);
                beanDefinitions.add(beanDefinition);
            }
        } catch (ParserConfigurationException | SAXException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return beanDefinitions;
    }

    private static Class<?> getClassType(String typeName) throws ClassNotFoundException {
        switch (typeName) {
            case "String":
                return String.class;
            case "int":
                return int.class;
            // Add other types as needed
            default:
                return Class.forName(typeName);
        }
    }

    private static Object parseValue(Class<?> type, String value) {
        if (type == int.class) {
            return Integer.parseInt(value);
        } else if (type == String.class) {
            return value;
        }
        // Add other type conversions as needed
        return null;
    }

    public static String convert(InputStream inputStream) {
        try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
            return scanner.useDelimiter("\\A").next();
        }
    }
}
