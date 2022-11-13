/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.c.ProjectIDcard;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author athar
 */
@Controller
public class IdController {
    @RequestMapping("/ProjectCard")
    public String getData(@RequestParam("name") String nama,
                          @RequestParam("tanggal")@DateTimeFormat(pattern ="yyyy-MM-dd") Date date,
                          @RequestParam("gambar") MultipartFile file,
                          Model model) throws IOException{
        
        SimpleDateFormat idc = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        String tanggal = idc.format(date);
        
        String blob = Base64.encodeBase64String(file.getBytes());
        String gambar = "data:image/jpeg;base64,".concat(blob);
        
        model.addAttribute("nm", nama);
        model.addAttribute("tgl", tanggal);
        model.addAttribute("gmbr", gambar);
                
        return "card";
    }
            
}
