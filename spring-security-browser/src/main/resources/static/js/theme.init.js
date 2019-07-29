// Popover
(function($) {

    'use strict';

    if ( $.isFunction( $.fn['popover'] ) ) {
        $( '[data-toggle=popover]' ).popover();
    }

}).apply(this, [jQuery]);

// Tooltip
(function($) {

    'use strict';

    if ( $.isFunction( $.fn['tooltip'] ) ) {
        $( '[data-toggle=tooltip],[rel=tooltip]' ).tooltip({ container: 'body' });
    }

}).apply(this, [jQuery]);

// Scroll to Top
(function(theme, $) {
    // Scroll to Top Button.
    if (typeof theme.PluginScrollToTop !== 'undefined') {
        theme.PluginScrollToTop.initialize();
    }
}).apply(this, [window.theme, jQuery]);

// iosSwitcher
(function($) {

    'use strict';

    if ( $.isFunction( $.fn.confirmation ) ) {

        $.extend( $.fn.confirmation.Constructor.DEFAULTS, {
            btnOkIcon 		: 'fa fa-check',
            btnCancelIcon 	: 'fa fa-times'
        });

    }

}).apply(this, [jQuery]);

// iosSwitcher
(function($) {

    'use strict';

    if ( typeof Switch !== 'undefined' && $.isFunction( Switch ) ) {

        $(function() {
            $('[data-plugin-ios-switch]').each(function() {
                var $this = $( this );

                $this.themePluginIOS7Switch();
            });
        });

    }

}).apply(this, [jQuery]);

// MaxLength
(function($) {

    'use strict';

    if ( $.isFunction( $.fn[ 'maxlength' ]) ) {

        $(function() {
            $('[data-plugin-maxlength]').each(function() {
                var $this = $( this ),
                    opts = {};

                var pluginOptions = $this.data('plugin-options');
                if (pluginOptions)
                    opts = pluginOptions;

                $this.themePluginMaxLength(opts);
            });
        });

    }

}).apply(this, [jQuery]);

(function($) {

    'use strict';

    if ( $.isFunction( $.fn[ 'placeholder' ]) ) {

        $('input[placeholder]').placeholder();

    }

}).apply(this, [jQuery]);

// Animate
(function($) {

    'use strict';

    if ( $.isFunction($.fn[ 'appear' ]) ) {

        $(function() {
            $('[data-plugin-animate], [data-appear-animation]').each(function() {
                var $this = $( this ),
                    opts = {};

                var pluginOptions = $this.data('plugin-options');
                if (pluginOptions)
                    opts = pluginOptions;

                $this.themePluginAnimate(opts);
            });
        });

    }

}).apply(this, [jQuery]);

// Carousel
(function($) {

    'use strict';

    if ( $.isFunction($.fn[ 'owlCarousel' ]) ) {

        $(function() {
            $('[data-plugin-carousel]').each(function() {
                var $this = $( this ),
                    opts = {};

                var pluginOptions = $this.data('plugin-options');
                if (pluginOptions)
                    opts = pluginOptions;

                $this.themePluginCarousel(opts);
            });
        });

    }

}).apply(this, [jQuery]);

// Lightbox
(function($) {

    'use strict';

    if ( $.isFunction($.fn[ 'magnificPopup' ]) ) {

        $(function() {
            $('[data-plugin-lightbox], .lightbox:not(.manual)').each(function() {
                var $this = $( this ),
                    opts = {};

                var pluginOptions = $this.data('plugin-options');
                if (pluginOptions)
                    opts = pluginOptions;

                $this.themePluginLightbox(opts);
            });
        });

    }

}).apply(this, [jQuery]);

// Portlets
(function($) {

    'use strict';

    if ( typeof NProgress !== 'undefined' && $.isFunction( NProgress.configure ) ) {

        NProgress.configure({
            showSpinner: false,
            ease: 'ease',
            speed: 750
        });

    }

}).apply(this, [jQuery]);

// Portlets
(function($) {

    'use strict';

    $(function() {
        $('[data-plugin-portlet]').each(function() {
            var $this = $( this ),
                opts = {};

            var pluginOptions = $this.data('plugin-options');
            if (pluginOptions)
                opts = pluginOptions;

            $this.themePluginPortlet(opts);
        });
    });

}).apply(this, [jQuery]);

// Scrollable
(function($) {

    'use strict';

    if ( $.isFunction($.fn[ 'nanoScroller' ]) ) {

        $(function() {
            $('[data-plugin-scrollable]').each(function() {
                var $this = $( this ),
                    opts = {};

                var pluginOptions = $this.data('plugin-options');
                if (pluginOptions) {
                    opts = pluginOptions;
                }

                $this.themePluginScrollable(opts);
            });
        });

    }

}).apply(this, [jQuery]);

// Slider
(function($) {

    'use strict';

    if ( $.isFunction($.fn[ 'slider' ]) ) {

        $(function() {
            $('[data-plugin-slider]').each(function() {
                var $this = $( this ),
                    opts = {};

                var pluginOptions = $this.data('plugin-options');
                if (pluginOptions) {
                    opts = pluginOptions;
                }

                $this.themePluginSlider(opts);
            });
        });

    }

}).apply(this, [jQuery]);

// Toggle
(function($) {

    'use strict';

    $(function() {
        $('[data-plugin-toggle]').each(function() {
            var $this = $( this ),
                opts = {};

            var pluginOptions = $this.data('plugin-options');
            if (pluginOptions)
                opts = pluginOptions;

            $this.themePluginToggle(opts);
        });
    });

}).apply(this, [jQuery]);