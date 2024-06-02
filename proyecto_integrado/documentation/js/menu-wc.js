'use strict';

customElements.define('compodoc-menu', class extends HTMLElement {
    constructor() {
        super();
        this.isNormalMode = this.getAttribute('mode') === 'normal';
    }

    connectedCallback() {
        this.render(this.isNormalMode);
    }

    render(isNormalMode) {
        let tp = lithtml.html(`
        <nav>
            <ul class="list">
                <li class="title">
                    <a href="index.html" data-type="index-link">proyecto-integrado documentation</a>
                </li>

                <li class="divider"></li>
                ${ isNormalMode ? `<div id="book-search-input" role="search"><input type="text" placeholder="Type to search"></div>` : '' }
                <li class="chapter">
                    <a data-type="chapter-link" href="index.html"><span class="icon ion-ios-home"></span>Getting started</a>
                    <ul class="links">
                        <li class="link">
                            <a href="overview.html" data-type="chapter-link">
                                <span class="icon ion-ios-keypad"></span>Overview
                            </a>
                        </li>
                        <li class="link">
                            <a href="index.html" data-type="chapter-link">
                                <span class="icon ion-ios-paper"></span>README
                            </a>
                        </li>
                                <li class="link">
                                    <a href="dependencies.html" data-type="chapter-link">
                                        <span class="icon ion-ios-list"></span>Dependencies
                                    </a>
                                </li>
                                <li class="link">
                                    <a href="properties.html" data-type="chapter-link">
                                        <span class="icon ion-ios-apps"></span>Properties
                                    </a>
                                </li>
                    </ul>
                </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-bs-toggle="collapse" ${ isNormalMode ? 'data-bs-target="#components-links"' :
                            'data-bs-target="#xs-components-links"' }>
                            <span class="icon ion-md-cog"></span>
                            <span>Components</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? 'id="components-links"' : 'id="xs-components-links"' }>
                            <li class="link">
                                <a href="components/ActividadesComponent.html" data-type="entity-link" >ActividadesComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/AdminPanelComponent.html" data-type="entity-link" >AdminPanelComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/AppComponent.html" data-type="entity-link" >AppComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/DetalleActividadComponent.html" data-type="entity-link" >DetalleActividadComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/EditarActividadComponent.html" data-type="entity-link" >EditarActividadComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/ForoDetalleComponent.html" data-type="entity-link" >ForoDetalleComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/ForosComponent.html" data-type="entity-link" >ForosComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/IndexComponent.html" data-type="entity-link" >IndexComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/LoginComponent.html" data-type="entity-link" >LoginComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/LoginOfertanteComponent.html" data-type="entity-link" >LoginOfertanteComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/NavComponent.html" data-type="entity-link" >NavComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/OfertantesPanelComponent.html" data-type="entity-link" >OfertantesPanelComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/PerfilConsumidorComponent.html" data-type="entity-link" >PerfilConsumidorComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/PerfilOfertanteComponent.html" data-type="entity-link" >PerfilOfertanteComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/RegisterConsumidorComponent.html" data-type="entity-link" >RegisterConsumidorComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/RegisterOfertanteComponent.html" data-type="entity-link" >RegisterOfertanteComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/RegistroActComponent.html" data-type="entity-link" >RegistroActComponent</a>
                            </li>
                            <li class="link">
                                <a href="components/UsuarioEditarComponent.html" data-type="entity-link" >UsuarioEditarComponent</a>
                            </li>
                        </ul>
                    </li>
                        <li class="chapter">
                            <div class="simple menu-toggler" data-bs-toggle="collapse" ${ isNormalMode ? 'data-bs-target="#injectables-links"' :
                                'data-bs-target="#xs-injectables-links"' }>
                                <span class="icon ion-md-arrow-round-down"></span>
                                <span>Injectables</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                            <ul class="links collapse " ${ isNormalMode ? 'id="injectables-links"' : 'id="xs-injectables-links"' }>
                                <li class="link">
                                    <a href="injectables/ActividadServiceService.html" data-type="entity-link" >ActividadServiceService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/AuthServiceService.html" data-type="entity-link" >AuthServiceService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/ConsumidorServiceService.html" data-type="entity-link" >ConsumidorServiceService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/ForoServiceService.html" data-type="entity-link" >ForoServiceService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/LoginServiceService.html" data-type="entity-link" >LoginServiceService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/NavServiceService.html" data-type="entity-link" >NavServiceService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/OfertanteServiceService.html" data-type="entity-link" >OfertanteServiceService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/OfertaServiceService.html" data-type="entity-link" >OfertaServiceService</a>
                                </li>
                                <li class="link">
                                    <a href="injectables/RegisterServiceService.html" data-type="entity-link" >RegisterServiceService</a>
                                </li>
                            </ul>
                        </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-bs-toggle="collapse" ${ isNormalMode ? 'data-bs-target="#interfaces-links"' :
                            'data-bs-target="#xs-interfaces-links"' }>
                            <span class="icon ion-md-information-circle-outline"></span>
                            <span>Interfaces</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? ' id="interfaces-links"' : 'id="xs-interfaces-links"' }>
                            <li class="link">
                                <a href="interfaces/Actividad.html" data-type="entity-link" >Actividad</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Categoria.html" data-type="entity-link" >Categoria</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Consumidor.html" data-type="entity-link" >Consumidor</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Foro.html" data-type="entity-link" >Foro</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Intereses.html" data-type="entity-link" >Intereses</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Login.html" data-type="entity-link" >Login</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Mensaje.html" data-type="entity-link" >Mensaje</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Oferta.html" data-type="entity-link" >Oferta</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/Ofertante.html" data-type="entity-link" >Ofertante</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/User.html" data-type="entity-link" >User</a>
                            </li>
                        </ul>
                    </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-bs-toggle="collapse" ${ isNormalMode ? 'data-bs-target="#miscellaneous-links"'
                            : 'data-bs-target="#xs-miscellaneous-links"' }>
                            <span class="icon ion-ios-cube"></span>
                            <span>Miscellaneous</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? 'id="miscellaneous-links"' : 'id="xs-miscellaneous-links"' }>
                            <li class="link">
                                <a href="miscellaneous/variables.html" data-type="entity-link">Variables</a>
                            </li>
                        </ul>
                    </li>
                    <li class="chapter">
                        <a data-type="chapter-link" href="coverage.html"><span class="icon ion-ios-stats"></span>Documentation coverage</a>
                    </li>
                    <li class="divider"></li>
                    <li class="copyright">
                        Documentation generated using <a href="https://compodoc.app/" target="_blank" rel="noopener noreferrer">
                            <img data-src="images/compodoc-vectorise.png" class="img-responsive" data-type="compodoc-logo">
                        </a>
                    </li>
            </ul>
        </nav>
        `);
        this.innerHTML = tp.strings;
    }
});