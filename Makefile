#
#   Makefile - plot-1d
#
#   This is the main makefile for building the Java language project named 'plot-1d'
#


# Define project directory variables
SRC = ./src/
SRC_PLOT = ./src/plot1d/
SRC_GRAPHICS = ./src/plot1d/graphicElements/

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
	$(SRC_PLOT)InputObject.java \
	$(SRC_PLOT)PlotGUI.java \
	$(SRC_PLOT)PlotFrame.java \
	$(SRC_PLOT)PlotPanel.java \
	$(SRC_PLOT)DataSet.java \
	$(SRC_PLOT)DataField.java \
	$(SRC_PLOT)DataPoint.java \
	$(SRC_PLOT)BoxTransform.java \
	$(SRC_PLOT)Extent.java \
	$(SRC_GRAPHICS)BorderBox.java \
	$(SRC_GRAPHICS)PlotPoint.java \


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
	rm $(BUILD)*.class

