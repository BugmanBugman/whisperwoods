package its_meow.whisperwoods.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;

public class EntityTypeContainer<T extends LivingEntity> {

    public EntityType<T> entityType;
    public SpawnEggItem egg;

    public final Class<T> entityClass;
    public final String entityName;
    public final EntityClassification spawnType;
    public final Function<World, T> factory;
    public final int eggColorSolid;
    public final int eggColorSpot;
    public int spawnWeight;
    public int spawnMinGroup;
    public int spawnMaxGroup;
    private final Set<Biome> biomes = new HashSet<Biome>();
    public boolean doSpawning = true;
    public final float width;
    public final float height;
    public boolean despawn;

    private Biome[] spawnBiomes;

    private EntityConfiguration config;

    private final CustomConfigurationHolder customConfig;

    public EntityTypeContainer(Class<T> EntityClass, Function<World, T> func,
    String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, boolean despawn, @Nullable CustomConfigurationHolder customConfig, BiomeDictionary.Type... biomeTypes) {
        this(EntityClass, func, entityNameIn, type, solidColorIn, spotColorIn, prob, min, max, width, height, despawn, customConfig, toBiomes(biomeTypes));
    }

    public EntityTypeContainer(Class<T> EntityClass, Function<World, T> func, String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, boolean despawn, @Nullable CustomConfigurationHolder customConfig, Biome... biomes) {
        this(EntityClass, func, entityNameIn, type, solidColorIn, spotColorIn, prob, min, max, width, height, despawn, customConfig, toBiomes(biomes));
    }

    public EntityTypeContainer(Class<T> EntityClass, Function<World, T> func, String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, boolean despawn, @Nullable CustomConfigurationHolder customConfig, Set<Biome> biomes) {
        this.entityClass = EntityClass;
        this.factory = func;
        this.entityName = entityNameIn;
        this.eggColorSolid = solidColorIn;
        this.eggColorSpot = spotColorIn;
        this.spawnWeight = prob;
        this.spawnMinGroup = min;
        this.spawnMaxGroup = max;
        this.spawnType = type;
        this.width = width;
        this.height = height;
        this.despawn = despawn;
        this.customConfig = customConfig;
        this.biomes.addAll(biomes);
    }

    public void initConfiguration(ForgeConfigSpec.Builder builder) {
        this.config = new EntityConfiguration(builder);
    }

    public EntityConfiguration getConfiguration() {
        return this.config;
    }

    public void setBiomes(Biome... biomes) {
        this.spawnBiomes = biomes;
    }

    public Biome[] getBiomes() {
        return spawnBiomes;
    }

    public class EntityConfiguration {
        public ForgeConfigSpec.BooleanValue doSpawning;
        public ForgeConfigSpec.IntValue spawnMinGroup;
        public ForgeConfigSpec.IntValue spawnMaxGroup;
        public ForgeConfigSpec.IntValue spawnWeight;
        public ForgeConfigSpec.ConfigValue<List<? extends String>> biomesList;
        public List<String> biomeStrings;
        public ForgeConfigSpec.BooleanValue doDespawn;

        protected EntityConfiguration(ForgeConfigSpec.Builder builder) {
            EntityTypeContainer<T> container = EntityTypeContainer.this;
            builder.push(container.entityName);
            this.biomeStrings = Arrays.asList(container.getBiomeIDs());
            this.loadSpawning(builder);
            this.loadSpawnValues(builder, container);
            doDespawn = builder.comment("True if this entity can despawn freely when no players are nearby.").worldRestart().define("doDespawn", container.despawn);
            EntityTypeContainer.this.customConfigurationInit(builder);
            builder.pop();
        }

        public void loadSpawning(ForgeConfigSpec.Builder builder) {
            doSpawning = builder.comment("Disables natural spawning").worldRestart().define("doSpawning", true);
        }

        public void loadSpawnValues(ForgeConfigSpec.Builder builder, EntityTypeContainer<T> container) {
            spawnWeight = builder.comment("The spawn chance compared to other entities (typically between 6-20)").worldRestart()
            .defineInRange("weight", container.spawnWeight, 1, 9999);
            spawnMinGroup = builder.comment("Must be greater than 0").worldRestart().defineInRange("minGroup", container.spawnMinGroup, 1,
            9999);
            spawnMaxGroup = builder.comment("Must be greater or equal to min value!").worldRestart().defineInRange("maxGroup",
            container.spawnMaxGroup, 1, 9999);
            biomesList = builder.comment("Enter biome Resource Locations. Supports modded biomes.").worldRestart()
            .defineList("spawnBiomes", biomeStrings, (Predicate<Object>) input -> input instanceof String);
        }
    }

    private static Set<Biome> toBiomes(BiomeDictionary.Type[] biomeTypes) {
        Set<Biome> biomes = new HashSet<Biome>();
        for(BiomeDictionary.Type type : biomeTypes) {
            biomes.addAll(BiomeDictionary.getBiomes(type));
        }
        return biomes;
    }

    private static Set<Biome> toBiomes(Biome[] biomes2) {
        Set<Biome> biomes = new HashSet<Biome>();
        biomes.addAll(Lists.newArrayList(biomes2));
        return biomes;
    }

    public String[] getBiomeIDs() {
        try {
            spawnBiomes = biomes.toArray(new Biome[0]);
        } catch(NullPointerException e) {
            spawnBiomes = new Biome[0];
        }
        String[] biomeStrings = new String[spawnBiomes.length];
        for(int i = 0; i < spawnBiomes.length; i++) {
            biomeStrings[i] = spawnBiomes[i].getRegistryName().toString();
        }
        return biomeStrings;
    }

    public void customConfigurationLoad() {
        if(this.customConfig != null) {
            this.customConfig.customConfigurationLoad();
        }
    }

    public void customConfigurationInit(ForgeConfigSpec.Builder builder) {
        if(this.customConfig != null) {
            this.customConfig.customConfigurationInit(builder);
        }
    }

    public static abstract class CustomConfigurationHolder {
        protected abstract void customConfigurationInit(ForgeConfigSpec.Builder builder);
        protected abstract void customConfigurationLoad();
    }

}
