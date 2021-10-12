## Task:
- Rewrite createdb.sql script for db nova poshta:
- - the script must be done in proper to 3NF.
- - script must run several times without errors.
- - create for tables index`s where it is needed.
- Plus rewrite populate sqript.

### hOw tO rUn
- clone
```
git clone https://github.com/ArSiu/dblab.git
cd dblab
git checkout lab3
```
- run at terminal which are connected to mysql db mysql source (path to one of scripts)
```
mysql>  source ... dblab\createdb.sql
mysql>  source ... dblab\populate.sql
```
