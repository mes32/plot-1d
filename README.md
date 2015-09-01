# plot-1d
![Screenshot of sine function scatter plot](./resources/images/screenshots/damped_harmonic_oscillator.png)

Generate scatter plots from formatted text files

## Usage
Launch the application using the shell script `plot-1d.sh`. This script takes a single text file as input.

```
cd ./plot-1d
./plot-1d.sh <data.1d>
```

The input data file should contain two columns of numbers separated by a space. The first column gives x-axis values and the second column gives the corresponding y-axis value. For example a text file containing the following represents a few data points on the line `y = 2x + 1` for the x values equal to {0, 1, 2, 3, 4}.

```
0 1
1 3
2 5
3 7
4 9
```

## Example Input Data

You can find sample input files under `./test/data`.

```
# Plots a damped harmonic oscillator over time
./plot-1d.sh ./test/data/damped_harmonic_oscillator.1d

# Plots a square wave
./plot-1d.sh ./test/data/square_wave.1d

# Plots the population of the Bronx by year
# x: year
# y: population of Bronx County, New York
./plot-1d.sh ./test/data/population_bronx.1d

# Plots mean world-wide atmospheric CO2 by year
# x: year (negative values indicate BC)
# y: Estimated world-wide atomospheric Carbon Dioxide concentration in parts per million
./plot-1d.sh ./test/data/atmospheric_C02_ppm.1d
```

## Requirements
To run you will need Java 7 JRE runtime environment or later. To develop you will need Java 7 JDK development kit and you will probably find make useful.

## Licence
Copyright 2015 Michael Stockman

This program is provided under the MIT License. You are generally free to use plot-1d for anything you find useful. See LICENSE for details.
