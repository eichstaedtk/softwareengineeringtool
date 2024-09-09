import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import client_1 from "./connect-client.default.js";
import type Projekt_1 from "./de/eichstaedt/engineering/domain/Projekt.js";
async function findProjekt_1(init?: EndpointRequestInit_1): Promise<Projekt_1 | undefined> { return client_1.call("ProjektController", "findProjekt", {}, init); }
async function saveProjekt_1(projekt: Projekt_1 | undefined, init?: EndpointRequestInit_1): Promise<void> { return client_1.call("ProjektController", "saveProjekt", { projekt }, init); }
export { findProjekt_1 as findProjekt, saveProjekt_1 as saveProjekt };
