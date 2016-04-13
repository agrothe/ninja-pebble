Pebble template module for Ninja framework.
===========================================
Pebble (http://www.mitchellbosecke.com/pebble/home) is a java template template engine inspired by Twig. It separates itself from the crowd with it's inheritance feature and it's easy-to-read syntax. It ships with built-in autoescaping for security, and it includes integrated support for internationalization.

This is an easly plugable module for Ninja web framework to write templates using Pebble template engine. Based on the [ninja-mustache](https://github.com/kpacha/ninja-mustache) module.


Getting started
---------------

Setup
-----

1) Add the ninja-pebble dependency to your pom.xml:

        <dependency>
            <groupId>com.github.jjfidalgo</groupId>
            <artifactId>ninja-pebble-module</artifactId>
            <version>0.2.0</version>
        </dependency>

2) Install the module in your conf.Module:

    @Override
    protected void configure() {

        ...

        install(new NinjaPebbleModule());

        ...

    }
    
   
If you want to use any Pebble extension you must install the module in your conf.Module as follows

    @Override
    protected void configure() {

        ...

        install(new NinjaPebbleModule(new CustomExtension()));

        ...

    }
    
    
Please refer to Pebble documentation about how to create your own Pebble extensions,

http://www.mitchellbosecke.com/pebble/documentation/guide/extending-pebble
    
3) All set. Start writing template in 'views' folder of your application.


4) Or check out <code>ninja-pebble-demo</code> (in progress). Run the below commands under demo:

    mvn ninja:run


Modify code/template -- Save -- Refresh browser. Enjoy!


