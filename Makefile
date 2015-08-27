#
#   Makefile - plot-1d
#
#   This is the main makefile for building the Java language project named 'plot-1d'
#


# Define project directory variables
SRC = ./src/
SRC_PLOT = ./src/plot1d/
SRC_DATA = ./src/plot1d/data/
SRC_GUI = ./src/plot1d/gui/

BUILD = ./build/classes/

CP = 'build/classes'


# Define java compiler and compiler flag variables
JFLAGS = -g -d $(BUILD)
JC = javac


# Reset default values of SUFFIXES to find Java source files and Java class files
.SUFFIXES: .java .class


# Define a general rule for creating .class files from .java files
# **** Doesn't seem useful just yet
#.java.class:
#	$(JC) $(JFLAGS) $*.java


# List each java source code file that needs to be compiled into a class file
CLASSES = \
	$(SRC)Plot1dApp.java \
	$(SRC_DATA)InputObject.java \
	$(SRC_DATA)DataSet.java \
	$(SRC_DATA)DataField.java \
	$(SRC_DATA)DataPoint.java \
	$(SRC_DATA)RegionExtent.java \
	$(SRC_GUI)PlotGUI.java \
	$(SRC_GUI)PlotFrame.java \
	$(SRC_GUI)PlotPanel.java \
	$(SRC_GUI)BorderBox.java \
	$(SRC_GUI)MappingToGUI.java \
	$(SRC_GUI)AbstractAxis.java \
	$(SRC_GUI)HorizontalAxis.java \
	$(SRC_GUI)PrimaryHorizontalAxis.java \
	$(SRC_GUI)SecondaryHorizontalAxis.java \
	$(SRC_GUI)VerticalAxis.java \
	$(SRC_GUI)PrimaryVerticalAxis.java \
	$(SRC_GUI)SecondaryVerticalAxis.java \


# Set the default make target
all: classes


# This target entry uses Suffix Replacement to replace all .java suffixes with .class suffixes
# **** Doesn't seem useful just yet
#classes: $(CLASSES:.java=.class)


# Make all the .class files for the project
classes: $(CLASSES)
	$(JC) -g -d $(BUILD) -cp $(CP) $(CLASSES)


# Set the clean behavior
clean:
	rm -f $(BUILD)*.class ; rm -f $(BUILD)plot1d/*.class ; rm -f $(BUILD)plot1d/data/*.class ; rm -f $(BUILD)plot1d/gui/*.class

