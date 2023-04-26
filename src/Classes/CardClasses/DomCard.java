package Classes.CardClasses;

import Classes.Player;

public class DomCard {
    private String name {public get;}
    private int cost {public get;}
    private int victoryPoints = 0 {public get;}
    private int treasureValue = 0 {public get;}
    private int buys = 0 {public get;}
    private String effect = "" {public get;}
    private String art = "" {public get;}
    private String type {public get;}
    private int drawammount = 0 {public get;}
    private int additionalActions = 0 {public get;}
    private int villagers = 0 {public get;}
    private int coffers = 0 {public get;}


    // masterconstructor with optional parameters
    public DomCard(String Name, String Type, int Cost, ?int VictoryPoints = 0, ?int TreasureValue = 0, ?int Draws = 0, ?int AddActions = 0, ?int addBuys=0,
            ?int Coffers = 0, ?int Villagers = 0, ?String Effect = "", ?String Art = "") {
        this.name = Name;
        this.cost = Cost;
        this.victoryPoints = VictoryPoints;
        this.treasureValue = TreasureValue;
        this.effect = Effect;
        this.type = Type;
        this.drawammount = Draws;
        this.additionalActions = AddActions;
        this.buys= AddBuys;
        this.coffers = Coffers;
        this.villagers = Villagers;
        if art != ""{this.art = Art;};
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