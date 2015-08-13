

# Absolute path to this script
# A roughly portable version of "readlink -f"
SCRIPT="${PWD}/${0}"

# Absolute path to the directory this script is in
PROJECT_DIR=`dirname ${SCRIPT}`

# Absolute path to compiled class files
BUILD_DIR=${PROJECT_DIR}/build/classes/

CLASSPATH=${BUILD_DIR}

java -cp "${CLASSPATH}" Plot1dApp ./test/data/sine.1d
