package Classes.CardClasses;

import Classes.Player;

public class DomCard {
    private String name;
    private int cost;
    private int victoryPoints = 0;
    private int treasureValue = 0;
    private int buys = 0;
    private String effect = "";
    private String art = "";
    private String type;
    private int drawammount = 0;
    private int additionalActions = 0;
    private int villagers = 0;
    private int coffers = 0;


    // masterconstructor with optional parameters
    public DomCard(String Name, String Type, int Cost, int VictoryPoints = 0, int TreasureValue = 0, int Draws = 0, int AddActions = 0, addBuys=0,
            int Coffers = 0, int Villagers = 0, String Effect = "", String Art = "") {
        this.name = name;
        this.cost = cost;
        this.victoryPoints = victoryPoints;
        this.treasureValue = treasureValue;
        this.effect = effect;
        this.type = type;
        this.drawammount = draws;
        this.additionalActions = addActions;
        this.buys= addBuys;
        this.coffers = coffers;
        this.villagers = villagers;
        if art != ""{this.art = art;};
    }

    public void play(Player activPlayer) {
        activPlayer.addActions(this.additionalActions);
        activPlayer.addCoins(this.treasureValue);
        activPlayer.addCoffers(this.coffers);
        activPlayer.addVillagers(this.villagers);
        activPlayer.addBuys(this.buys);
        for (int i = 0; i < drawammount; i++) {
            activPlayer.drawFromDeck();
        }
    }

    public void purchace(Player activPlayer) {
        activPlayer.setCoins(-cost);
    }

    public String getName() {
        return this.name;
    }

    public String getPrettyName() {
        String template = " |                              | ";
        int start = (template.length() - this.name.length()) / 2;
        int end = start + this.name.length();
        return template.substring(0, start) + this.name + template.substring(end);
    }

    public String getPrettyCostType() {
        String template = " |(" + this.cost + ")                           | ";
        int start = (template.length() - this.type.length()) / 2;
        int end = start + this.type.length();
        return template.substring(0, start) + this.type + template.substring(end);
    }

    public int getCost() {
        return this.cost;
    }

    public int getVictoryPoints() {
        return this.victoryPoints;
    }

    public int getTreasureValue() {
        return this.treasureValue;
    }

    public String getEffect() {
        return this.effect;
    }

    public String getEffect_Line(int linenum) {
        String[] lines = this.effect.split("\\r?\\n");
        if (lines.length < linenum) {
            return " |  .                        .  | "; // filler line
        } else {
            return lines[linenum - 1];
        }
    }

    public String getArt() {
        return this.art;
    }

    public String getType() {
        return this.type;
    }

    private String setDefaultArt() {
        String DefArt = "";
        DefArt += "\n|  _______________________  |";
        DefArt += "\n| |                       | |";
        DefArt += "\n| |           Art         | |";
        DefArt += "\n| |_______________________| |";
        return DefArt;
    }

    public void prettyPrint() {
        System.out.println("\n ============================== ");
        System.out.println("|     " + this.name + "   |");
        System.out.println(this.art);
        // System.out.println("______________________________");
        if (this.victoryPoints != 0) {
            System.out.println("|     " + this.victoryPoints + " VP  |");
        }
        if (!this.effect.isEmpty()) {
            System.out.println(this.effect);

        }
        System.out.println(" ____________________________ ");
        System.out.println("|            Cost: (" + this.cost + ") |");
        System.out.println("|    Type: " + this.type + "    |");
        System.out.println("==============================\n");
    }

}