package com.esieeAPE.lib;

import com.esieeAPE.objects.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Predicat {
    public List<Integer> list_int = new ArrayList<Integer>();
    public Entity entity = null;

    public abstract myVector3D isTrue(Entity entity);
}