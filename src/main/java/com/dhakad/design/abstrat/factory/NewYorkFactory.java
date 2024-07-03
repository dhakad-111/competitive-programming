package com.dhakad.design.abstrat.factory;

public class NewYorkFactory implements MobileFactory {

    @Override
    public MiModel getInstance(ModelType modelType) {
        switch (modelType) {
            case MI_BOLT:
                return new MiBolt();
			case MI_FIRE:
                return new MiFire();
            default:
                throw new IllegalArgumentException("Invalid model type !.");
        }
    }

}
