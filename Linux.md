### Задание 1:

1) Используйте команды операционной системы Linux и создайте
   две новых директории – «Игрушки для школьников» и «Игрушки
   для дошколят»

> dmitry@ubuntu-vb:~/IntermediateAttestationLinux$ mkdir Игрушки\ для\ школьников Игрушки\ для\ дошколят

2) Создайте в директории «Игрушки для школьников» текстовые
   файлы - «Роботы», «Конструктор», «Настольные игры»

> dmitry@ubuntu-vb:~/IntermediateAttestationLinux$ cd Игрушки\ для\ школьников/  
> dmitry@ubuntu-vb:~/IntermediateAttestationLinux/Игрушки для школьников$ touch Роботы Конструктор Настольные\ игры

3) Создайте в директории «Игрушки для дошколят» текстовые
   файлы «Мягкие игрушки», «Куклы», «Машинки»

> dmitry@ubuntu-vb:~/IntermediateAttestationLinux$ cd Игрушки\ для\ дошколят/  
> dmitry@ubuntu-vb:~/IntermediateAttestationLinux/Игрушки для дошколят$ touch Куклы Машинки Мягкие\ игрушки

4) Объединить 2 директории в одну «Имя Игрушки»

> dmitry@ubuntu-vb:~/IntermediateAttestationLinux$ mkdir Имя\ Игрушки; cp -a 'Игрушки для школьников'/* 'Игрушки для дошколят'/* 'Имя Игрушки'; rm -rf 'Игрушки для школьников'; rm -rf 'Игрушки для дошколят'

5) Переименовать директорию «Имя Игрушки» в «Игрушки»

> dmitry@ubuntu-vb:~/IntermediateAttestationLinux$ mv Имя\ Игрушки/ Игрушки

6) Просмотреть содержимое каталога «Игрушки».

> dmitry@ubuntu-vb:~/IntermediateAttestationLinux$ cd Игрушки/; ls -al

7) Установить и удалить snap-пакет. (Любой, какой хотите)

> dmitry@ubuntu-vb:~$ sudo snap install chromium  
> chromium 111.0.5563.64 from Canonical✓ installed  
> dmitry@ubuntu-vb:~$ sudo snap remove chromium  
> chromium removed

8) Добавить произвольную задачу для выполнения каждые 3
   минуты (Например, запись в текстовый файл чего-то или
   копирование из каталога А в каталог Б).

> dmitry@ubuntu-vb:~/IntermediateAttestationLinux$ crontab -e  
> */3 * * * * echo 'Hello' >> /home/dmitry/IntermediateAttestationLinux/test.log