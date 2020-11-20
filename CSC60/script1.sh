#!/bin/bash

array="fall spring summer"

for string in $array
do
    list=`ls $string`
    for file in $list
    do
        if [[  -f$file == *.c   ]]
        then
            echo "$file"
            cd $string
            exec `gcc $file`
            ./a.out
            cd ../
        fi
    done
done