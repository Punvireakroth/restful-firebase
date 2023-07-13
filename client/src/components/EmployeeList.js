import React, { useState, useEffect } from "react";

function EmployeeList() {
  const [employee, setEmployee] = useState(null);

  useEffect(() => {
    async function fetchEmployee() {
      const response = await fetch("/get?documentId=user_2");

      const data = await response.json();
      setEmployee(data);
    }

    fetchEmployee();
  }, []);

  return (
    <div className="employee-list">
      {employee ? (
        <div>
          <h1>{employee.name}</h1>
          <p>Attendance: {employee.attendance}</p>
          <p>Position: {employee.position}</p>
          <p>Salary: {employee.salary}</p>
          <p>Work Department: {employee.workdepartment}</p>
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
}

export default EmployeeList;
