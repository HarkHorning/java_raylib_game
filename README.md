# Java and Kotlin game built with Raylib using Java bindings

Still being developed.

## Gnome Survivor

You play as a gnome as endless hordes of foul creatures attack you. You must escape and become more powerful.

You will find more abilities the farther you adventure, but also more danger.

## How it works

## Why

I originally made this game using plain Java and the JFrame library -- which worked sometimes.

## Process

I originally architected the game to run off of two main threads for update calls and render calls respectively. Since this is a 2D game, I decided that these two 
threads were unnecessary and it made more sence to use smaller virtual threads for individual tasks like loading textures and such.

## Known Issues

