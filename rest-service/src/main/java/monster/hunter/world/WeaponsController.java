package monster.hunter.world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(WeaponsController.WEAPON)
public class WeaponsController {
    public static final String WEAPON = "/weapon";

    @Autowired
    private WeaponsService weaponsService;

    @GetMapping()
    public String getAllWeapons(Model model) {
        List<Weapon> weapons = weaponsService.getAllWeapons();
        model.addAttribute("weapons", weapons);
        return "weapons";
    }

    @GetMapping("/{id}")
    public String getWeaponDetails(@PathVariable Long id, Model model) {
        // Obtener la información de la arma por ID
        Weapon weapon = weaponsService.getWeaponById(id);

        // Verificar si la arma existe
        if (weapon != null) {
            model.addAttribute("weapon", weapon);
        } else {
            // Puedes manejar el caso en el que no se encuentre la arma
            model.addAttribute("errorMessage", "Weapon not found");
        }

        return "weaponDetails"; // Nombre de la vista para mostrar detalles de una arma específica
    }

}


