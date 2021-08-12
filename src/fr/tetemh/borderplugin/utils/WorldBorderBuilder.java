package fr.tetemh.borderplugin.utils;

import org.bukkit.World;
import org.bukkit.WorldBorder;

public class WorldBorderBuilder {
    private static WorldBorder wb;

    public static void create(World world){
        wb = world.getWorldBorder();
        wb.reset();
        wb.setCenter(0, 0);
    }

    public static void setCenter(double a, double b) {
        wb.setCenter(a, b);
    }

    public static void setSize(double a, long b) {
        wb.setSize(a, b);
    }

    public static void reset(){
        wb.reset();
    }

    public static void setWarningDistance(int distance) {
        wb.setWarningDistance(distance);
    }

    public static void setDamageAmount(double life) {
        wb.setDamageAmount(life);
    }

    public static void setDamamgeBuffer(double distance) {
        wb.setDamageBuffer(distance);
    }

    public static void setDamamgeAmount(double dammage) {
        wb.setDamageAmount(dammage);
    }

    public static void setWarmingTime(int time) {
        wb.setWarningTime(time);
    }
}
