package edu.escuelaing.arsw.picas.controlador;

import edu.escuelaing.arsw.picas.modelo.Picasmodelo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Picascontrolador {
    Picasmodelo picasmodelo = new Picasmodelo();;
    int picas;
    int famas;
    String num;
    int numRandom;
    List<String> lista  = new ArrayList<>();
    public Picascontrolador(){
        picas = 0;
        famas = 0;
        numRandom = (int) (Math.random() * 1000);
    }

    @GetMapping("/jugar")
    public String getPagina(Model model){
        model.addAttribute("famas", picasmodelo.getFamas());
        model.addAttribute("picas", picasmodelo.getPicas());
        model.addAttribute("lista", picasmodelo.getLista());
        model.addAttribute("getNumRandom", picasmodelo.getNumRandom());
        return "jugar";
    }

    @PostMapping("/jugar")
    public String postPagina(String num){
        lista.add(num);
        this.num = num;
        this.picas = picasmodelo.getPicas();
        this.famas = picasmodelo.getFamas();
        this.lista = picasmodelo.getLista();

        picasmodelo.checknum(num);
        return "redirect:/jugar";
    }

    @RequestMapping(value = "/jugar", method = RequestMethod.POST, params = {"reiniciar"})
    public String reiniciar(){
        picasmodelo.reiniciar();
        return "redirect:/jugar";
    }

}
