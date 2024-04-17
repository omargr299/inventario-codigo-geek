package com.inv.inventario.controllers;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inv.inventario.Exceptions.RangeDateException;
import com.inv.inventario.Models.Activo;
import com.inv.inventario.Services.ActivoService;

@Controller()
public class MainController {

    @Autowired
    private ActivoService service;


    public String formatURL(String queryLike,String fechaAdquiStart,String fechaAdquiEnd,int ubicacionLike,String StatusLike,int page){
        String url = page == 0 ? "&" : "?";
        if (!queryLike.equals("")) url += "query="+queryLike+"&";
        if (!fechaAdquiStart.equals("")) url += "fechaAdquiStart="+fechaAdquiStart+"&";
        if (!fechaAdquiEnd.equals("")) url += "fechaAdquiEnd="+fechaAdquiEnd+"&";
        if (ubicacionLike != 0) url += "ubicacion="+ubicacionLike+"&";
        if (!StatusLike.equals("")) url += "status="+StatusLike+"&";
        if (page != 0) url += "page="+page+"&";
        return url;
    }

    @GetMapping("/form")
    public String form(){
        return "form";
    }

    @GetMapping("/")
    public String index(
        @RequestParam(name="page", required=false, defaultValue = "0") int page,
        @RequestParam(name="query", required=false, defaultValue="") String queryLike,
        @RequestParam(name="fechaAdquiStart", required = false, defaultValue = "") String fechaAdquiStart,
        @RequestParam(name="fechaAdquiEnd", required = false, defaultValue = "") String fechaAdquiEnd,
        @RequestParam(name="ubicacion", required=false, defaultValue="0") int ubicacionLike,
        @RequestParam(name="status", required=false, defaultValue="") String StatusLike,
        @RequestParam(name="error", required=false, defaultValue="0") int error,
        Model model
) throws SQLException { 
        System.out.println("error: "+error);
        model.addAttribute("prev", 1);
        model.addAttribute("currentPage", 1);
        model.addAttribute("next", 1);
        model.addAttribute("pages", 1);
        model.addAttribute("error", error);
        	
        System.out.println(queryLike.equals("¿"));
        if(queryLike.equals("¿")) {
        	throw new SQLException();
        	}

        if (error!=0) return "index";

        if (page <= 0) return "redirect:/"+formatURL(queryLike,fechaAdquiStart,fechaAdquiEnd,ubicacionLike,StatusLike,1);

        try{
            int length = service.getCount(queryLike,fechaAdquiStart,fechaAdquiEnd,ubicacionLike,StatusLike);
            int totalPages = (length/4)+1;
            System.out.println("Paginas: " + totalPages);
            if (page > totalPages) return "redirect:/"+formatURL(queryLike,fechaAdquiStart,fechaAdquiEnd,ubicacionLike,StatusLike,totalPages);
            model.addAttribute("pages", totalPages);
        }
        catch (RangeDateException e){
            System.err.println(e.getMessage());
            return "redirect:/?error=1";
        }
        catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
            return "redirect:/?error=5";
        }
        
        try{
            Page<Activo> activos = service.getAll(queryLike,fechaAdquiStart,fechaAdquiEnd,ubicacionLike,StatusLike,page);
            model.addAttribute("activos",activos);
            System.out.println("Activos: "+activos.getContent().size());
            
        }
        catch (RangeDateException e){
            System.err.println(e.getMessage());
            return "redirect:/?error=2";
        }
        catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
            return "redirect:/?error=5";
        }

        String paramsURL = formatURL(queryLike,fechaAdquiStart,fechaAdquiEnd,ubicacionLike,StatusLike,0);
        model.addAttribute("prev", page-1);
        model.addAttribute("currentPage", page);
        model.addAttribute("next", page+1);
        model.addAttribute("params", paramsURL);
        return "index";
    }

    
    @ExceptionHandler(SQLException.class)
    public String sqlerror( Model model) {
    	System.out.println("sql");
    	model.addAttribute("prev", 1);
        model.addAttribute("currentPage", 1);
        model.addAttribute("next", 1);
        model.addAttribute("pages", 1);
        model.addAttribute("error", 1);
        return "redirect:/?error=1";
    }
    @ExceptionHandler(HibernateException.class)
    public String hibernaterror(Model model) {
    	System.out.println("sql");
    	model.addAttribute("prev", 1);
        model.addAttribute("currentPage", 1);
        model.addAttribute("next", 1);
        model.addAttribute("pages", 1);
        model.addAttribute("error", 1);
        return "redirect:/?error=1";
    }
}
