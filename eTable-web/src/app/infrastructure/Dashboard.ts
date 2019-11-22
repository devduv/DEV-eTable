import { DisplayGrid, GridsterConfig, GridsterItem, GridType } from 'angular-gridster2';
import { Colors } from './constans/Colors';
export class Dashboard {

    private options: GridsterConfig;
    private dashboard: Array<GridsterItem>;

    constructor() {
        this.setOptionsDashboard();
        this.setDashboard();
    }

    setDashboard() {
        this.dashboard = [];
    }
    setOptionsDashboard() {
        this.options = {
            gridType: GridType.Fit,
            fixedColWidth: 90, fixedRowHeight: 40,
            margin: 8, minCols: 1, minRows: 1, maxCols: 3, maxRows: 3,
            pushItems: true,
            displayGrid: DisplayGrid.Always,
            draggable: { enabled: false },
            resizable: { enabled: false }
        };
    }

    removeItem($event: { stopPropagation: () => void; }, item: GridsterItem) {
        $event.stopPropagation();
        this.dashboard.splice(this.dashboard.indexOf(item), 1);
    }

    addSection(dashboard: any, id: number) {
        if (id === 1) {
            this.addVideo(dashboard);
        } else if (id === 2) {
            this.addBanner(dashboard);
        } else if (id === 3) {
            this.addTicket(dashboard);
        }
    }

    emptyCellClick(item: GridsterItem) {
        if (this.options.api.getNextPossiblePosition(item)) {
            return true;
        } else {
            alert(item.label + ' (' + item.rows + ' x ' + item.cols + ')' + ' no se puede agregar debido a que excede de la Distribución.');
            return false;
        }

    }
    addTicket(dashboard: any) {
        const item = {
            id: 0, cols: 2, rows: 2, y: undefined, x: undefined,
            minItemRows: 2, minItemCols: 2,
            label: 'Zona Ticket',
            type: 3,
            prog: false,
            color: Colors.TICKET
        };
        if (this.emptyCellClick(item)) {
            dashboard.push(item);
        }
    }

    addVideo(dashboard: any) {
        const item = {
            id: 0, cols: 2, rows: 2, y: undefined, x: undefined,
            minItemRows: 2, minItemCols: 2,
            label: 'Zona Video',
            type: 1,
            prog: false,
            color: Colors.VIDEO
        };
        if (this.emptyCellClick(item)) {
            dashboard.push(item);
        }
    }

    addBanner(dashboard: any) {
        const item = {
            id: 0, cols: 1, rows: 1, y: undefined, x: undefined,
            minItemRows: 1, minItemCols: 1,
            label: 'Zona Banner',
            type: 2,
            prog: false,
            color: Colors.BANNER
        };
        if (this.emptyCellClick(item)) {
            dashboard.push(item);
        }
    }

    removeAll(dashboard: Array<GridsterItem>) {
        const size = dashboard.length;
        if (size !== 0) {
            let i = 0;
            while (i < size) {
                dashboard.splice(dashboard.indexOf(dashboard[i]), 1);
                i++;
            }
        }
    }

    isDashboardEmpty(dashboard: Array<GridsterItem>) {
        const widthTotal = 10;
        const heightTotal = 10;
        const totalArea = widthTotal * heightTotal;
        let auxArea = 0;
        const size = dashboard.length;
        if (size !== 0) {
            let i = 0;
            while (i < size) {
                auxArea = auxArea + dashboard[i].cols * dashboard[i].rows;
                i++;
            }
            if (auxArea !== totalArea) {
                return true;
            } else {
                return false;
            }
        }
    }

    length() {
        return this.dashboard.length;
    }

    push(item: any) {
        return this.dashboard.push(item);
    }

    getDashboard() {
        return this.dashboard;
    }

    getOptions() {
        return this.options;
    }

    get(id: number) {
        return this.dashboard[id];
    }

}
