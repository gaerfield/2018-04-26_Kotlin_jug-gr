package de.kramhal.planetexpress.bender;

import java.util.Collections;
import java.util.List;

import de.kramhal.planetexpress.leela.ExtensionsKt;
import de.kramhal.planetexpress.leela.Leela;
import de.kramhal.planetexpress.leela.LeelaKt;
import de.kramhal.planetexpress.leela.ExtensionsKt.*;

class Bender
{
    void getLeelasBeer(){
        Leela leela = new Leela();
        LeelaKt.echo("Boom");
        //new Beer().drink();
        //leela.getBackupBeer$production_sources_for_module_leela_main()
        leela.letsDrinkABeer();
        leela.setAge(20);
    }

    public static void main(String[] args)
    {
        new Bender().getLeelasBeer();
        System.out.println(ExtensionsKt.extend("Haha"));
    }
}
