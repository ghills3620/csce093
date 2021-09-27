package BattleShip;

public class Destroyer extends Ship{

    private final char Operational_Hull = 'D';
    private final char Damanged_Hull = 'd';

    public Destroyer(String name) {
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
        return 3;
    }
}