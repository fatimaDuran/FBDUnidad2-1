package utng.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import utng.model.Media;

public class MediaDOM {
		private String pathFile = "C:\\Users\\Home\\eclipse-workspace\\FBDUnidad2\\src\\data\\medias.xml";

		public void add(Media data) {
			try {

				Document document = DOMHelper.getDocument(pathFile);
				Element medias = document.getDocumentElement();
				// Create media tag
				Element media = document.createElement("media");
				// Create id tag
				Element id = document.createElement("id");
				id.appendChild(document.createTextNode(data.getId()));
				media.appendChild(id);
				// Create x_uuid tag
				Element x_uuid = document.createElement("x_uuid");
				x_uuid.appendChild(document.createTextNode(data.getX_uuid()));
				media.appendChild(x_uuid);
				// Create url tag
				Element url = document.createElement("url");
			url.appendChild(document.createTextNode(data.getUrl()));
				media.appendChild(url);

				Element media_type = document.createElement("media_type");
				media_type.appendChild(document.createTextNode(data.getMedia_type()));
				media.appendChild(media_type);
				medias.appendChild(media);
				// Write to File
				DOMHelper.saveXMLContent(document, pathFile);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		public void delete(String id) {
			try {
				Document document = DOMHelper.getDocument(pathFile);
				NodeList nodeList = document.getElementsByTagName("media");
				for (int i = 0; i < nodeList.getLength(); i++) {
					Element media = (Element) nodeList.item(i);
					if (media.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
						media.getParentNode().removeChild(media);
					}
				}
				DOMHelper.saveXMLContent(document, pathFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void update(Media data) {
			try {
				Document document = DOMHelper.getDocument(pathFile);
				NodeList nodeList = document.getElementsByTagName("media");
				for (int i = 0; i < nodeList.getLength(); i++) {
					Element media = (Element) nodeList.item(i);
					if (media.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
						media.getElementsByTagName("x_uuid").item(0).setTextContent(data.getX_uuid());
						media.getElementsByTagName("url").item(0).setTextContent(data.getUrl());
						media.getElementsByTagName("media_type").item(0).setTextContent(data.getMedia_type());
						

					}
				}
				DOMHelper.saveXMLContent(document, pathFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public Media findById(String id) {
			Media media = null;
			try {
				Document document = DOMHelper.getDocument(pathFile);
				NodeList nodeList = document.getElementsByTagName("media");
				for (int i = 0; i < nodeList.getLength(); i++) {
					Element s = (Element) nodeList.item(i);
					if (s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
						media = new Media();
						media.setId(id);
						media.setX_uuid(s.getElementsByTagName("x_uuid").item(0).getTextContent());
						media.setUrl(s.getElementsByTagName("url").item(0).getTextContent());
						media.setMedia_type(s.getElementsByTagName("media_type").item(0).getTextContent());
					

					}

				}
				DOMHelper.saveXMLContent(document, pathFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return media;
		}

		public List<Media> getMedias() {
			List<Media> medias = new ArrayList<Media>();
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("media");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element s = (Element) nodeList.item(i);
				Media media = new Media();
				media.setId(s.getElementsByTagName("id").item(0).getTextContent());
				media.setX_uuid(s.getElementsByTagName("x_uuid").item(0).getTextContent());
				media.setUrl(s.getElementsByTagName("url").item(0).getTextContent());
				media.setMedia_type(s.getElementsByTagName("media_type").item(0).getTextContent());
				
				medias.add(media);
			}
			return medias;
		}

}
