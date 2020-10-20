package com.epam.hometask.seven.observable;

import com.epam.hometask.seven.model.Cube;

public interface Observer {

    void notify(CubeObservable cubeObservable);
}
