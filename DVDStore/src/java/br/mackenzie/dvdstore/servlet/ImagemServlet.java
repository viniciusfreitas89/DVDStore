package br.mackenzie.dvdstore.servlet;

import br.mackenzie.dvdstore.dao.MidiaDAO;
import br.mackenzie.dvdstore.services.MidiaService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sun.misc.IOUtils;
//import org.gicm.cms.CMSDao;
//import org.gicm.model.UploadedImage;
@WebServlet("/images/*")
public class ImagemServlet extends HttpServlet {
   @PersistenceContext()
   private EntityManager em;
   @EJB
   private MidiaService bean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRealPath("resources/images/imgNotFound.png");
        
        String strId = request.getParameter("id");
        byte[] image = null;
        if (strId!=null && !strId.isEmpty()){
            Long id = Long.parseLong(strId);
            image = bean.loadImage(id); // Get Image from DB.
        }
        if (image==null){
            File file = new File(path);
            image = read(file);
        }
        if (image!=null){
            response.setHeader("Content-Type", getServletContext().getMimeType("image"));
            response.setHeader("Content-Disposition", "inline; filename=\"image\"");

            BufferedInputStream input = null;
            BufferedOutputStream output = null;

            try {
                ByteArrayInputStream in = new ByteArrayInputStream(image);

                input = new BufferedInputStream(in); // Creates buffered input stream.
                output = new BufferedOutputStream(response.getOutputStream());
                byte[] buffer = new byte[8192];
                for (int length = 0; (length = input.read(buffer)) > 0;) {
                    output.write(buffer, 0, length);
                }
            } finally {
                if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
                if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
            }
        }
    }
    
    public byte[] read(File file) throws IOException{
        FileInputStream fin = null;
        FileChannel ch = null;
        byte[] bytes = null;
        try {
            fin = new FileInputStream(file);
            ch = fin.getChannel();
            int size = (int) ch.size();
            MappedByteBuffer buf = ch.map(MapMode.READ_ONLY, 0, size);
            bytes = new byte[size];
            buf.get(bytes);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (ch != null) {
                    ch.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
       return bytes;
    }
}