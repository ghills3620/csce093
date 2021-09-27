package BattleShip;

public class Cruiser extends Ship{

    private final char Operational_Hull = 'C';
    private final char Damanged_Hull = 'c';

    public Cruiser(String name) {
        super(name);
    }

    @Override
    public char drawShipStatusAtCell(boolean isDamaged) {
        if(isDamaged)
            return this.Damanged_Hull;
        return this.Operational_Hull;
    }

    @Override
    public int getLength() {
        return 4;
    }
}