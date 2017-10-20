package utng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import utng.dom.MediaDOM;

import utng.model.Media;



/**
 * Servlet implementation class MediaController
 */
@WebServlet("/MediaController")
public class MediaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Media media;
	private List<Media> medias;
	private MediaDOM mediaDOM;

	private List<String> ids = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MediaController() {
        super();
		media = new Media();
		medias = new ArrayList<Media>();
		mediaDOM = new MediaDOM();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

		
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			if (request.getParameter("btn_save") != null) {

				media.setX_uuid(request.getParameter("x_uuid"));
				media.setUrl(request.getParameter("url"));
				media.setMedia_type(request.getParameter("media_type"));
				
				System.out.println("save");
				if (media.getId() == "") {
					String newId = "MD" + String.format("%02d", 1);
					media.setId(newId);
					if (medias.size() > 0) {
						ids.clear();
						for (Media s : medias) {
							ids.add(s.getId());
						}
						for (int i = 0; i <= ids.size(); i++) {
							newId = "MD" + String.format("%02d", i + 1);
							if (!ids.contains(newId)) {
								media.setId(newId);
								break;
							}
						}
					}
					System.out.println("save");
					mediaDOM.add(media);
				} else {
					mediaDOM.update(media);
				}

				medias = mediaDOM.getMedias();

				request.setAttribute("medias", medias);
				request.getRequestDispatcher("media_list.jsp").forward(request, response);

			} else if (request.getParameter("btn_new") != null) {
				media = new Media();
				request.getRequestDispatcher("media_form.jsp").forward(request, response);
			} else if (request.getParameter("btn_edit") != null) {
				try {

					String id = request.getParameter("id");
					media = mediaDOM.findById(id);

				} catch (Exception e) {
					media = new Media();
				}
				request.setAttribute("media", media);
				request.getRequestDispatcher("media_form.jsp").forward(request, response);

			} else if (request.getParameter("btn_delete") != null) {
				try {
					String id = request.getParameter("id");
					mediaDOM.delete(id);
					medias = mediaDOM.getMedias();
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.setAttribute("medias", medias);
				request.getRequestDispatcher("media_list.jsp").forward(request, response);
			} else {
				medias = mediaDOM.getMedias();
				request.setAttribute("medias", medias);
				request.getRequestDispatcher("media_list.jsp").forward(request, response);
			}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
