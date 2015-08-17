grammar kalang;

start:
    statList
;

statList:stat*;
stat:assignStat;

assignStat:
Identifier ':' expr
;
expr:
 'as' Identifier
 |'new ' Identifier
 | Identifier*
;