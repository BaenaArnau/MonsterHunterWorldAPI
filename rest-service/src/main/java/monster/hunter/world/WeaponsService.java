package monster.hunter.world;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class WeaponsService {
    private static final String API_URL = "https://mhw-db.com/weapons";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Weapon> getAllWeapons() {
        try {
            Weapon[] weapons = restTemplate.getForObject(API_URL, Weapon[].class);
            return Arrays.asList(weapons);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Weapon getWeaponById(Long id) {
        try {
            String specificWeaponUrl = API_URL + "/" + id;
            Weapon weapon = restTemplate.getForObject(specificWeaponUrl, Weapon.class);
            return weapon;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

