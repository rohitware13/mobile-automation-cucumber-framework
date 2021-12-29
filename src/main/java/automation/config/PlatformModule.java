package automation.config;



import com.google.inject.Module;

public  enum PlatformModule {

    IOS {
        @Override
        public Module getModule()
        {
            return new IosModule();
        }
    },

    ANDROID {
        @Override
        public Module getModule() {
            return new AndroidModule();
        }
    };


    public abstract Module getModule();
}
