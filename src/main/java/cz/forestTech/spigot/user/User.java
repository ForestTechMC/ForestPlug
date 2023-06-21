package cz.forestTech.spigot.user;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.GameMode;

import java.util.UUID;

@Getter
@Setter
public class User {

    private String name;

    private UUID uuid;

    private String lastLoc;

    private long firstJoin;
    private long lastJoin;

    private boolean isInvulnerable;
    private boolean isAbleToFly;
    private GameMode currentGameMode;

}
