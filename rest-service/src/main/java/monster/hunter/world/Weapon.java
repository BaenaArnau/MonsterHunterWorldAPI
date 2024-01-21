package monster.hunter.world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Weapon(
        Long id,
        String name,
        String type,
        Integer rarity,
        Attack attack,
        String elderseal,
        Attributes attributes,
        String damageType,
        List<Durability> durability,
        List<Slot> slots,
        List<Element> elements,
        Crafting crafting,
        Assets assets
) {
}

record Attack(Integer display, Integer raw) {
}

record Attributes(String damageType) {
}

record Durability(
        Integer red,
        Integer orange,
        Integer yellow,
        Integer green,
        Integer blue,
        Integer white,
        Integer purple
) {
}

record Slot(Integer rank) {
}

record Element(String type, Integer damage, Boolean hidden) {
}

record Crafting(
        Boolean craftable,
        Integer previous,
        List<Integer> branches,
        List<CraftingMaterial> craftingMaterials,
        List<UpgradeMaterial> upgradeMaterials
) {
}

record CraftingMaterial(Integer quantity, Item item) {
}

record UpgradeMaterial(Integer quantity, Item item) {
}

record Item(Long id, String name, String description, Integer rarity, Integer carryLimit, Integer value) {
}

record Assets(String icon, String image) {
}

