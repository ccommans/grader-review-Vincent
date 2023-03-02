CPATH='.;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf *.class
rm -rf *.txt
rm -rf ListExamples.java

git clone $1 student-submission
if [[ $? -ne 0 ]]
then 
    echo 'Clone Failed.'
    exit
fi

echo 'Finished cloning'

if [[ -f student-submission/ListExamples.java ]]
then
    cp student-submission/ListExamples.java ./
else
    echo 'student-submission/ListExamples.java not found'
    exit
fi

javac -cp $CPATH *.java 2>compile-err.txt
if [[ $? -ne 0 ]]
then
    echo 'Compile Failed'
    cat compile-err.txt
    exit
fi


java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > exec-err.txt
if [[ $? -ne 0 ]]
then
    echo 'Test execution failed'
    cat exec-err.txt
    exit
fi


