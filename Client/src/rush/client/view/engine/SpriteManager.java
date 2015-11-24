package rush.client.view.engine;

import java.util.*;

public class SpriteManager {
    private List<Sprite> gameActors = new ArrayList<>();
    private Set<Sprite> cleanupSprites = new HashSet<>();
    
    public List<Sprite> getAllSprites() {
        return gameActors;
    }
    
    public void addSprites(Sprite... sprites) {       
        gameActors.addAll(Arrays.asList(sprites));
    }

    public void removeSprites(Sprite... sprites) {       
        gameActors.removeAll(Arrays.asList(sprites));
    }

    public Set<Sprite> getSpritesToBeRemoved() {
        return cleanupSprites;
    }

    public void addSpritesToBeRemoved(Sprite... sprites) {
        if (sprites.length > 1) {
            cleanupSprites.addAll(Arrays.asList((Sprite[]) sprites));
        } else {
            cleanupSprites.add(sprites[0]);
        }
    }

    public void cleanupSprites() {
        gameActors.removeAll(cleanupSprites);
        cleanupSprites.clear();
    }
}
