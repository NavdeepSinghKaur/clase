package comparison.controller;

import comparison.models.Sticker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Album {
    private ArrayList<Sticker> albumArrayList;
    private HashSet<Sticker> albumHashSet;
    private TreeSet<Sticker> albumTreeSet;

    public Album() {
        albumArrayList = new ArrayList<>();
        albumHashSet = new HashSet<>();
        albumTreeSet = new TreeSet<>();
    }

    public long loadFileIntoArrayList(String filename) {
        String[] line = filename.replace(" ", "").split(",");
        long start = 0;
        long end = 0;
        if (line.length == 2) {
            String name = line[0];
            int year = Integer.parseInt(line[1]);
            start = System.nanoTime();
            albumArrayList.add(new Sticker(name, year));
            end = System.nanoTime();
        }
        return end - start;
    }

    public long loadFileIntoHasSet(String filename) {
        String[] line = filename.replace(" ", "").split(",");
        long start = 0;
        long end = 0;
        if (line.length == 2) {
            String name = line[0];
            int year = Integer.parseInt(line[1]);
            start = System.nanoTime();
            albumHashSet.add(new Sticker(name, year));
            end = System.nanoTime();
        }
        return end - start;
    }

    public long loadFileIntoTreeSet(String filename) {
        String[] line = filename.replace(" ", "").split(",");
        long start = 0;
        long end = 0;
        if (line.length == 2) {
            String name = line[0];
            int year = Integer.parseInt(line[1]);
            start = System.nanoTime();
            albumTreeSet.add(new Sticker(name, year));
            end = System.nanoTime();
        }
        return end - start;
    }

    public long containsStickerArrayList(Sticker st) {
        long start = 0;
        long end = 0;
        if(albumArrayList.contains(st)) {
            start = System.nanoTime();
            albumArrayList.contains(st);
            end = System.nanoTime();
        }

        return end-start;
    }

    public long containsStickerHashSet(Sticker st) {
        long start = 0;
        long end = 0;
        if(albumHashSet.contains(st)) {
            start = System.nanoTime();
            albumHashSet.contains(st);
            end = System.nanoTime();
        }

        return end-start;
    }

    public long containsStickerTreeSet(Sticker st) {
        long start = 0;
        long end = 0;
        if(albumTreeSet.contains(st)) {
            start = System.nanoTime();
            albumTreeSet.contains(st);
            end = System.nanoTime();
        }

        return end-start;
    }
}
