package uf2dailyexercises;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {List<String> allDirNames =
        Arrays.stream(Objects.requireNonNull(new File("/")
            .listFiles()))
            .filter(File::isDirectory)
            .map(File::getName)
            .collect(Collectors.toList());
    System.out.println(allDirNames);
    }
}
