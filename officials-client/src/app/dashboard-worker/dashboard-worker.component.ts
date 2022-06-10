import { Component, OnInit } from '@angular/core';

export interface User {
  ime: string;
  prezime: string;
  jmbg: number;
}

@Component({
  selector: 'app-dashboard-worker',
  templateUrl: './dashboard-worker.component.html',
  styleUrls: ['./dashboard-worker.component.css']
})
export class DashboardWorkerComponent implements OnInit {
  columns = [
    {
      columnDef: 'ime',
      header: 'Ime',
      cell: (element: User) => `${element.ime}`,
    },
    {
      columnDef: 'prezime',
      header: 'Prezime',
      cell: (element: User) => `${element.prezime}`,
    },
    {
      columnDef: 'jmbg',
      header: 'JMBG',
      cell: (element: User) => `${element.jmbg}`,
    }
  ];
  dataSource: User[] = [];
  displayedColumns = this.columns.map(c => c.columnDef);

  constructor() { }

  ngOnInit(): void {
  }

  finish() {}

  add() {}

  back() {}
}
