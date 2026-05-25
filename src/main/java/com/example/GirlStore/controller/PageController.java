package com.example.GirlStore.controller;

import java.util.List;

import com.example.GirlStore.model.CatalogProduct;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/labiales")
    public String labiales(Model model) {
        populateCategoryPage(
            model,
            "Labiales | Daniela Beauty",
            "Labiales",
            "COLECCIÓN EXCLUSIVA",
            "Acabados smooth, tonos coquette y texturas premium para looks delicados y elegantes.",
            "Labiales premium",
            "Selecciona tu tono favorito y agrégalo al carrito.",
            List.of(
                new CatalogProduct("Velvet Rose", "/img/labiales/labial-1.jpg", 42),
                new CatalogProduct("Pink Aura", "/img/labiales/labial-2.jpg", 48),
                new CatalogProduct("Nude Glow", "/img/labiales/labial-3.jpg", 55),
                new CatalogProduct("Satin Kiss", "/img/labiales/labial-4.jpg", 60),
                new CatalogProduct("Rose Mousse", "/img/labiales/labial-5.jpg", 68)
            )
        );

        return "labiales";
    }

    @GetMapping("/rubores")
    public String rubores(Model model) {
        populateCategoryPage(
            model,
            "Rubores | Daniela Beauty",
            "Rubores",
            "COLECCIÓN EXCLUSIVA",
            "Tonos románticos y difuminado suave para un efecto fresco, femenino y sofisticado.",
            "Rubores premium",
            "Colores delicados con acabado natural y elegante.",
            List.of(
                new CatalogProduct("Pink Silk", "/img/rubores/rubor-1.jpg", 38),
                new CatalogProduct("Soft Coral", "/img/rubores/rubor-2.jpg", 41),
                new CatalogProduct("Bloom Dust", "/img/rubores/rubor-3.jpg", 46),
                new CatalogProduct("Rosy Blush", "/img/rubores/rubor-4.png", 50),
                new CatalogProduct("Baby Peach", "/img/rubores/rubor-5.jpg", 54)
            )
        );

        return "rubores";
    }

    @GetMapping("/bases")
    public String bases(Model model) {
        populateCategoryPage(
            model,
            "Bases | Daniela Beauty",
            "Bases",
            "COLECCIÓN EXCLUSIVA",
            "Cobertura uniforme, acabado skin-like y sensación ligera para un look pulido y real.",
            "Bases premium",
            "Texturas suaves y resultados limpios para uso diario o maquillaje glam.",
            List.of(
                new CatalogProduct("Silk Finish", "/img/bases/base-1.jpg", 72),
                new CatalogProduct("Soft Matte", "/img/bases/base-2.jpg", 76),
                new CatalogProduct("Skin Veil", "/img/bases/base-3.jpg", 81),
                new CatalogProduct("Glow Blur", "/img/bases/base-4.jpg", 88),
                new CatalogProduct("Velvet Tone", "/img/bases/base-5.jpg", 94)
            )
        );

        return "bases";
    }

    @GetMapping("/sombras")
    public String sombras(Model model) {
        populateCategoryPage(
            model,
            "Sombras | Daniela Beauty",
            "Sombras",
            "COLECCIÓN EXCLUSIVA",
            "Paletas suaves y luminosas para crear looks románticos, glam y de inspiración editorial.",
            "Sombras premium",
            "Colores versátiles para difuminar, iluminar y definir.",
            List.of(
                new CatalogProduct("Soft Nude", "/img/sombras/sombra-1.jpg", 58),
                new CatalogProduct("Rose Dust", "/img/sombras/sombra-2.jpg", 62),
                new CatalogProduct("Golden Hour", "/img/sombras/sombra-3.jpg", 66),
                new CatalogProduct("Luxe Mauve", "/img/sombras/sombra-4.jpg", 71),
                new CatalogProduct("Cozy Plum", "/img/sombras/sombra-5.jpg", 75)
            )
        );

        return "sombras";
    }

    @GetMapping("/skincare")
    public String skincare(Model model) {
        populateCategoryPage(
            model,
            "Skincare | Daniela Beauty",
            "Skincare",
            "COLECCIÓN EXCLUSIVA",
            "Rutinas suaves, glow saludable y fórmulas elegantes para una piel cuidada y luminosa.",
            "Skincare premium",
            "Esenciales de cuidado facial con estética limpia y delicada.",
            List.of(
                new CatalogProduct("Glow Serum", "/img/skincare/skincare-1.jpg", 63),
                new CatalogProduct("Hydra Cream", "/img/skincare/skincare-2.jpg", 69),
                new CatalogProduct("Velvet Cleanser", "/img/skincare/skincare-3.jpg", 57),
                new CatalogProduct("Daily Glow Mask", "/img/skincare/skincare-4.avif", 61),
                new CatalogProduct("Soft Mist", "/img/skincare/skincare-5.jpg", 66)
            )
        );

        return "skincare";
    }

    @GetMapping("/iluminadores")
    public String iluminadores(Model model) {
        populateCategoryPage(
            model,
            "Iluminadores | Daniela Beauty",
            "Iluminadores",
            "COLECCIÓN BRILLO",
            "Polvos y líquidos para un glow sutil o intenso, según tu estilo.",
            "Iluminadores premium",
            "Ilumina estratégicamente y logra piel radiante.",
            List.of(
                new CatalogProduct("Radiant Beam", "/img/iluminadores/iluminador-1.jpg", 39),
                new CatalogProduct("Moonlight Dew", "/img/iluminadores/iluminador-2.jpg", 44),
                new CatalogProduct("Sunlit Pearl", "/img/iluminadores/iluminador-3.jpg", 49),
                new CatalogProduct("Champagne Glow", "/img/iluminadores/iluminador-4.jpg", 54),
                new CatalogProduct("Gilded Luxe", "/img/iluminadores/iluminador-5.jpg", 59)
            )
        );

        return "iluminadores";
    }

    private void populateCategoryPage(Model model,
                                      String pageTitle,
                                      String heroTitle,
                                      String heroEyebrow,
                                      String heroDescription,
                                      String sectionTitle,
                                      String sectionSubtitle,
                                      List<CatalogProduct> products) {
        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("heroTitle", heroTitle);
        model.addAttribute("heroEyebrow", heroEyebrow);
        model.addAttribute("heroDescription", heroDescription);
        model.addAttribute("sectionTitle", sectionTitle);
        model.addAttribute("sectionSubtitle", sectionSubtitle);
        model.addAttribute("products", products);
    }
}